package com.se.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileCustom {
	

	public static boolean saveFileBase64(String pathLocal, String nameFile, String extension, String base64) {
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64);
		try {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
			// write the image to a file
			File outputfile = new File(pathLocal,nameFile+"."+extension);
			outputfile.createNewFile();
			ImageIO.write(img, extension, outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
		return true;
	}
}
