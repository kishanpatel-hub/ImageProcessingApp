# README


##Image Model

Image Model is designed to operate on images and create images.

Image Model consist of following files:

  - IImageModel interface
  - ImageModel Class [implements IImageModel]
  - Image class 
  - GenerateImage class
  - ImageUtilities class
  - ImageList class
  - ImageListImpl class
  
##Image Controller
 
Image Controller is designed to control the program by taking input from the user and using model to perform operation and the view communicates with controller to get output. 

Image Controller consist of the following files

  - Features interface
  - ImageController class [Implements Features]

## Input Methods

Program supports the user entering input through command line.

Program supports following methods to interact with program.

### -interactive

Program launches GUI when interactive is called.

### -script filename.txt

Program supports the user entering input through command line by passing txt file to the program. Program reads through the txt file and performs operations accordingly. following are the command supported by the program.

###load [imagefile path]

loads the given image file into the program.

###save 

saves the processed image file back to the image file.

###blur

blurs the loaded image file.

###sharpen

sharpens the loaded image file.

###greyscale

Performs greyscale on the loaded image file.

###sepia

Performs sepia on the loaded image file.

###edgedetection

performs edge detection on the loaded image file.

###dithering

performs dithering in black and white on the loaded image file.

###rainbowVertical

generates the vertical rainbow image file for given width and height.

###rainbowHorizontal

generates the horizontal rainbow image file for given width and height.

###checkerboard

generates the checker board image file for given no of square on the sides.

###franceflag

generates the flag of france image file for given width and height.

###norwayflag

generates the flag of norway image file for given width and height.

###greeceflag

generates the flag of greece image file for given width and height.

###switzerlandflag

generates the flag of switzerland image file for given width and height.
  
# IImage interface

IImage interface offers following methods to load, save and perform modification [filter, color transformation] on images.
IImage interface offers following methods:

  - greyscale()
  - blur()
  - sharpen()
  - greyscale()
  - sepia()
  - getImage()
  - getHeight()
  - getwidth()
  - getName()
  

# ImageList class

The Interface ImageList represents list of images and offers operations on list of images such as loading, saving, displaying, and writing images using ImageUtilities class.

# Driver

The Class Driver is class consisting main method which works as controller for image model.

# Changes

##Second Iteration

The getImage() method was removed from the IImage interface and corresponding implementation as per the instruction, As it was exposing the image data to users and makes program vulnerable to data corruption.

##Third Iteration

To Implement true MVC keeping in mind MVC principles and separation between the model, view and controller, Major changes were made in the design of model and controller making sure that changes in one part has no/minimal effect on the others.

### Changes in Model

1. IImage interface was removed and IImageModel interface was added. This change represents chance in the role and ideology of the model where in the previous model, Model was representing Image and its functionality. Now IImageModel interface represents Model of the Image Operations which includes the **generate Image operations** which were not part of the model in previous interaction. This changes redefines the role of model in the program offering complete set of functionality related to images.

2. ImageModel class was added which is an Implementation of IImageModel interface. It implements all the functionality [blur, sharpen, greyscale, sepia, edge detection, dithering, mosaics, equalization, red-eye removal, image generation] offered by model by using image class which represents single image and set of operations that can be performed on it and GenerateImage class which represents set of static methods which are used to generate images[rainbow, checker board, flag of different countries]. 
 
### Changes in Controller

1. Features interface was added to effectively separate view and controller by features interface representing set of feature offered by controller which can be used by view to offer those feature to users. 

2. Controller was redesigned to implement Features interface and its methods. Controller now takes instance of model during initialization and uses setview() method to gain control over view. Controller now effectively communicates with view and model using their interface IImageModel and IImageView respectively. This changes makes it possible to have minimal coupling between Model, view and controller.

# image citation

##RedeyeGirl.png

###URL
https://instructure-uploads.s3.amazonaws.com/account_145230000000000001/attachments/317161/RedeyeGirl.png?response-content-disposition=attachment%3B%20filename%3D%22RedeyeGirl.png%22%3B%20filename%2A%3DUTF-8%27%27RedeyeGirl.png&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJDW777BLV26JM2MQ%2F20200511%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200511T123321Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=a684e942d0a1ac3762a91fc6c03d0c8c5d6b760e04bd87e351668cd164ae3896

##red-eye-in-photo-1200x630.jpg

###URL
https://images.ctfassets.net/u4vv676b8z52/2V3S619h1ZdLeS06QxyH5s/b272ab63dc05e19e266e8f12b25322db/red-eye-in-photo-1200x630.png_h_250?fm=jpg&q=80


##GO48R.png

###URL
https://i.stack.imgur.com/GO48R.png

##ContrastBefore.png

###URL
https://instructure-uploads.s3.amazonaws.com/account_145230000000000001/attachments/317159/ContrastBefore.png?response-content-disposition=attachment%3B%20filename%3D%22ContrastBefore.png%22%3B%20filename%2A%3DUTF-8%27%27ContrastBefore.png&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJDW777BLV26JM2MQ%2F20200510%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200510T235936Z&X-Amz-Expires=86400&X-Amz-SignedHeaders=host&X-Amz-Signature=3874ffcf49b5fa534e1e9f92287a37ce9c8911b3f5cc29add8871463d784053d

##manhattan-small.png

###URL
https://cdn.inst-fs-iad-prod.inscloudgate.net/340af4ac-cc8f-4fd6-95ac-21c2bc87cf66/manhattan-small.png?token=eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCIsImtpZCI6ImNkbiJ9.eyJyZXNvdXJjZSI6Ii8zNDBhZjRhYy1jYzhmLTRmZDYtOTVhYy0yMWMyYmM4N2NmNjYvbWFuaGF0dGFuLXNtYWxsLnBuZyIsInRlbmFudCI6ImNhbnZhcyIsInVzZXJfaWQiOiIxNDUyMzAwMDAwMDAwNzg2NDUiLCJpYXQiOjE1ODYxOTAyMDQsImV4cCI6MTU4NjI3NjYwNH0.-to2Zjc6ImAZBft2DeUvKYsLpa1k1xIOrswB2ERi8QFq6sFXr-kd54TNFnSQXyD5gXo9VzJ_INnsKMc3T3C00A&download=1&content_type=image%2Fpng

##Toronto-Skyline-at-twilight.jpg

###URL
https://www.google.com/url?sa=i&url=https%3A%2F%2Ffineartamerica.com%2Ffeatured%2Ftoronto-skyline-painting-peter-zicherman.html&psig=AOvVaw3k-K10rRS8Tbq6v-Q7qdLL&ust=1586317712377000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCW1JC01egCFQAAAAAdAAAAABAD
