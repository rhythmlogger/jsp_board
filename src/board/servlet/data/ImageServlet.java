package board.servlet.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the requested image file path
		String imagePath = request.getPathInfo();
		System.out.println(imagePath);
		// Construct the absolute file path on the server
		String absolutePath = getServletContext().getRealPath("/images") + imagePath;

		// Read the image file as bytes
		File imageFile = new File(absolutePath);
	
		FileInputStream fileInputStream = new FileInputStream(imageFile);

		byte[] buffer = new byte[fileInputStream.available()];
		fileInputStream.read(buffer);
		fileInputStream.close();
		
		// Set the response content type as image/jpeg
		response.setContentType("image/jpeg");

		// Write the image bytes to the response
		ServletOutputStream outputStream = response.getOutputStream();
		outputStream.write(buffer);
		outputStream.flush();
	}
}