# Object
Demonstrate the workflow to create a recipe based on autotools using devtools. Use for the source code the following repository: https://github.com/byuksel/Automake-Autoconf-Template-Project.git

**Note**: after building the recipe and deploying it to the target device, you will notice the limitations of autotools. The required libraries will not be transferred to the target device, but only the binary built within recipe.

**Resolution**: Add the recipe to the image, by placing IMAGE_INSTALL:append = " this_recipe_name" in the conf/local.conf file.
Upon deployment of the full core-image-whatever to the target, the binary will be copied along with the necessary libraries for its functionality.
