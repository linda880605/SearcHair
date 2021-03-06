package hairMatch;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Base64;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ToImgur {
	static final ImgurAPI imgurApi = createImgurAPI();

	public static String getImgur(String data, File newFile, String path) throws IOException {

		String fileName = null;
		fileName = CodeGenerator.getRandomCode(6); // generate a random file name
		String newFileName = fileName + ".png";
		File outputfile = new File(path + "/" + newFileName);
		if (data != null) {
			String base64Image = data.split(",")[1];
			byte[] imageBytes = Base64.getMimeDecoder().decode(base64Image);
			ByteArrayInputStream image = new ByteArrayInputStream(imageBytes);
			BufferedImage img = ImageIO.read(image);
			image.close();
			ImageIO.write(img, "png", outputfile);
		}
		if (newFile != null)
			copyFileUsingFileChannels(newFile, outputfile); // copy newFile to outputfile

		RequestBody request = RequestBody.create(MediaType.parse("image/*"), outputfile);
		Call<ImageResponse> call = imgurApi.postImage(request);
		Response<ImageResponse> res = call.execute();
		outputfile.delete(); // delete file
		return res.body().data.link;
	}

	static ImgurAPI createImgurAPI() {
		Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
				.baseUrl(ImgurAPI.SERVER).build();
		return retrofit.create(ImgurAPI.class);
	}

	private static void copyFileUsingFileChannels(File source, File dest) throws IOException {
		FileChannel inputChannel = null;
		FileChannel outputChannel = null;
		try {
			inputChannel = new FileInputStream(source).getChannel();
			outputChannel = new FileOutputStream(dest).getChannel();
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
		} finally {
			if (inputChannel != null)
				inputChannel.close();
			if (outputChannel != null)
				outputChannel.close();
		}
	}
}
