package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes it) {
        ImageReader imageReader;
        if (it == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (it == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (it == ImageTypes.PNG) {
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return imageReader;
    }
}
