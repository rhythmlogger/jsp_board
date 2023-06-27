package board.servlet.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/data-image")
public class UploadImageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String savePath = "C:/Workspace/jsp_board/WebContent/images/";
		Part filePart = request.getPart("upload");
		String fileName = UUID.randomUUID().toString() + ".jpg";
		OutputStream out = new FileOutputStream(new File(savePath + fileName));
		InputStream fileContent = filePart.getInputStream();
		int read;
		byte[] buffer = new byte[1024];
		while ((read = fileContent.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
		out.close();
		// Build the response JSON object
		String imageUrl = "/images/" + fileName; // Adjust the image URL as per your setup
		String jsonResponse = "{\"url\": \"" + imageUrl + "\", \"uploaded\": 1, \"fileName\": \"" + fileName + "\"}";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Set the response content type and write the JSON response
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
