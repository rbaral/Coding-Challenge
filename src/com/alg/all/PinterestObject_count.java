/*
Picture Object Count

Task

You are to write a function count_objects_in_picture(picture) which counts the number of objects that are in picture.  picture is a string that is the absolute path to a PNG file, which is a black and white picture. For example, in this image:

American Football Formation
there are 22 objects. An object is a grouping of black pixels that are contiguous. Two black pixels are contiguous if they are one pixel distance away from each other in any horizontal, vertical, or diagonal direction. For example, in:

Pixel Grid

All of the green pixels would be contiguous with the black pixel, but none of the white pixel locations would be.
Assumptions

The picture will be a valid PNG file
You can install packages to handle viewing the PNG file
The PNG file will not be empty
The PNG file will only include black and white colors
The RGB values of black are (0, 0, 0)
The RGB values of white are (255, 255, 255)
 */
package com.alg.realtest;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author rbaral
 */
public class PinterestObject_count {

    public static Integer count_objects_in_pictures(String filepath) {
        BufferedImage image;
        int width;
        int height;
        int objcount = 0;
        File input = new File(filepath);
        try {
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            //store the object's rows and cols
            List<String> listObj = new ArrayList<String>();//store the x,y coords that were marked for object

            for (int i = 0; i < width; i++) {

                for (int j = 0; j < height; j++) {
                    Color c = new Color(image.getRGB(i, j));
                    //System.out.println("S.No: " + count + " Red: " + c.getRed() + "  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                    //The RGB values of black are (0, 0, 0)
                    if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0){//a black cell
                        //check if its neighbors already considered for an object
                        listObj.add(i+""+j);
                        String left = (i-1)+""+j;
                        if(isValidCell(width, height, i-1, j) && listObj.contains(left)){//counted into left neighbor
                            continue;
                        }
                        
                        String up = i+""+(j-1);
                        if(isValidCell(width, height, i, j-1) && listObj.contains(up)){
                            continue;
                        }
                        String leftUp = (i-1)+""+(j+1);
                        if(isValidCell(width, height, i-1, j+1) && listObj.contains(leftUp))
                            continue;
                        //String down = i+""+(j+1);
                        String rightUp = (i+1)+""+(j+1);
                        if(isValidCell(width, height, i+1, j+1) && listObj.contains(rightUp))
                            continue;
                        //String right = i+""+(j+1);
                        //String rightDown = (i+1)+""+(j-1);
                        //String leftDown = (i-1)+""+(j-1);
                        //if none of the neighbors read so far were object, this is a valid object
                        objcount++;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(PinterestObject_count.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objcount;
    }
    
    public static boolean isValidCell(int width, int height, int i, int j){
        if(i>=0 && i<=width & j>=0 && j<=height){
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        int counts = count_objects_in_pictures("E:\\GitHub\\Coding-Challenge\\images.png");
        System.out.println(counts);
        
    }
    
}


