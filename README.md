# ImageProcessingApp
Image Processing Application is built using MVC architecture strictly following SOLID principles. The application was developed to learn best practices for design paradigms in development. The application uses different kernels to apply various filters on the image. It also offers functionality to edit and generate images.

Developed By: 

**Kishan Patel**

**Graduate Student (MSCS)**

**Northeastern University**

Detailed Internal architecture description can be found [here](https://github.com/kishanpatel-hub/ImageProcessingApp/blob/master/src/README.md).

## Configuration
To order to run the application, your operating system needs to run the Java SDK 8.

## Runnable JAR File
Click [here](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/FilterImage.jar) to download runnable JAR file.

## Input Methods

Program supports script as well as interactive mode to interact with the application. 

In order to run JAR file, follow given steps.

1. Download the [JAR](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/FilterImage.jar) file.
2. Open CMD in the exact same folder as the JAR file.
3. Type Following Command.

### To use Script

java -jar FilterImage.jar -script command.txt

### To use Interactive Mode

java -jar FilterImage.jar -interactive


## Interactive Mode

Program launches GUI when interactive mode is selected. 

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/Screenshot%20(191).png)

**A**: To browse through your local system in order to select image you want to edit. 

**B**: Load the image browsed in to the application.

**C**: Set of filters available that you can apply on image.

**D**: To generate custom images like rainbows, checkerboard, flags of different countries.

**E**: To reset the image to original image.

**F**: Set of image customizations like adding border or meme.

**G**: To select path where you want to save edited image.

**H**: To save image.

**I**: To Exit Application.

## Script 

Program supports the user entering input through command line by passing txt file to the program. Program reads through the txt file and performs operations accordingly. following are the command supported by the program. Example script can be found [here](https://github.com/kishanpatel-hub/ImageProcessingApp/blob/master/command.txt).

#### load [imagefile path]

loads the given image file into the program.

#### save [imagefile path]

saves the processed image file to the given image file path.

#### blur

blurs the loaded image file.

#### sharpen

sharpens the loaded image file.

#### greyscale

Performs greyscale on the loaded image file.

#### sepia

Performs sepia on the loaded image file.

#### edgedetection

performs edge detection on the loaded image file.

#### dithering

performs dithering in black and white on the loaded image file.

#### rainbowVertical

generates the vertical rainbow image file for given width and height.

#### rainbowHorizontal

generates the horizontal rainbow image file for given width and height.

#### checkerboard

generates the checker board image file for given no of square on the sides.

#### franceflag

generates the flag of france image file for given width and height.

#### norwayflag

generates the flag of norway image file for given width and height.

#### greeceflag

generates the flag of greece image file for given width and height.

#### switzerlandflag

generates the flag of switzerland image file for given width and height.

## Application previews

### Original Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/Toronto-Skyline-at-twilight.jpg)

### Blured Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/toronto-skyline-at-twilight_jpg_blured.jpg)

### Greyscale Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/toronto-skyline-at-twilight_jpg_Greyscale.jpg)

### Dithered Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/toronto-skyline-at-twilight_jpg_Greyscale_jpg_Dithering1.jpg)

### Sepia Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/toronto-skyline-at-twilight_jpg_Sepia.jpg)

### Mosaic Image with 1000 seeds

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/doc/Images/toronto-skyline-at-twilight_jpg_mosaic.jpg)

### Original Red Eye Girl Image

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/res/RedeyeGirl.png)

### Red Eye Removed

![alt text](https://github.com/kishanpatel-hub/ImageProcessingApp/raw/master/res/Screenshot%20(105).png)





