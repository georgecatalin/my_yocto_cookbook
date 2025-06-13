# Objective
Demonstrate the usage of FILESEXTRAPATHS in .bbappend files to include desired directories when looking for parsing other files
This file appears to record a detailed session of commands and outputs within a Yocto development environment. It primarily focuses on tasks related to building and debugging recipes using BitBake, which is the build tool used in Yocto.

### Key Points in the File:
1. **Environment Setup:**
   - The file starts with setting up the build environment using `source ../poky/oe-init-build-env`, which initializes the shell for Yocto-based builds.

2. **Common Targets:**
   - Lists common build targets like `core-image-minimal`, `core-image-full-cmdline`, `core-image-sato`, among others, which are typical outputs of BitBake commands.

3. **BitBake Commands:**
   - Several `bitbake` commands are executed throughout the session:
     - `bitbake -c do_cleansstate example`: Cleans the state of the example recipe.
     - `bitbake -e example | grep ^THIS_DIR=`: Retrieves the `THIS_DIR` variable, pointing to the directory path related to the recipe.
     - `bitbake example`: Attempts to build the example recipe.

4. **Warnings and Errors:**
   - Several warnings are displayed regarding the incorrect usage of the `FILESEXTRAPATHS` variable:
     - Correct format: `FILESEXTRAPATHS:append := ":${THISDIR}/Your_Files_Path"` or `FILESEXTRAPATHS:prepend := "${THISDIR}/Your_Files_Path:"`
     - Incorrect assignments are highlighted in the output.
   - Error in compilation (`do_compile` task) due to issues in the code (`bbb-example.h` file).

5. **Build Configuration:**
   - Details about the build configuration, including:
     - Target system (`arm-poky-linux-gnueabi`)
     - Machine (`beaglebone-yocto`)
     - Distribution (`poky`)
     - Layers used (`meta`, `meta-poky`, `meta-yocto-bsp`, etc.)

6. **Failed Tasks:**
   - Compilation failure in the recipe `example_0.1.bb` due to an error in the included header file (`bbb-example.h`).

7. **Debugging Attempts:**
   - Commands to locate or navigate the build directory (`grep ^S=`) and attempts to resolve issues using incorrect substitution or navigation commands.

8. **Usage of `FILESEXTRAPATHS`:**
   - The file emphasizes the importance of correctly appending or prepending paths using `FILESEXTRAPATHS` in `.bbappend` files for extending recipes.

### Purpose of the File:
The file serves as a practical example to demonstrate the use of `FILESEXTRAPATHS` in `.bbappend` files and provides insights into debugging errors and warnings in a Yocto build environment. It is useful for understanding common pitfalls and best practices in Yocto recipe development.


