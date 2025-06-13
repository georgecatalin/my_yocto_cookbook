## Task objective
Demonstrate the use of 'oe_runmake' with Yocto and making use of existing Makefile-s in recipes.

This file, `system_console.html`, appears to be a log or documentation of terminal commands and outputs related to building and configuring a Yocto Project environment. Here's a breakdown of its contents:

### Key Details:
1. **Terminal Commands and Navigation:**
   - The file documents terminal interactions, showing navigation into directories such as `yocto_tutorial`, `my_builds`, and various subdirectories.
   - Commands like `ls`, `cp`, and `cd` are used to explore and manipulate files and folders.

2. **Yocto Environment Setup:**
   - The script initializes the Yocto environment using `source ../poky/oe-init-build-env`.
   - It describes build targets like `core-image-minimal`, `core-image-sato`, and others that can be built with the `bitbake` tool.

3. **Layer Management:**
   - Layers are manipulated using `bitbake-layers` commands, such as showing, adding, and removing layers. Example:
     - Added layer `meta_advanced-calculator-makefile`.
     - Removed layer `meta-advanced-calculator`.

4. **Build Configuration:**
   - The configuration includes details about the system, such as:
     - `BB_VERSION`: BitBake version.
     - `BUILD_SYS`: Host system (e.g., `x86_64-linux`).
     - `TARGET_SYS`: Target system (e.g., `arm-poky-linux-gnueabi`).
     - Machine: `beaglebone-yocto`.

5. **Build Errors:**
   - Multiple build failures are logged, with errors related to the `Makefile`:
     - Missing separator (TAB vs spaces).
     - Recursive variable `CC` references itself.
     - Missing rules for targets like `math-lib.h` and `math-lib.c`.

6. **File Structure:**
   - The tree structure of the `meta_advanced-calculator-makefile` layer is shown, containing:
     - `conf/layer.conf`.
     - `recipes-example/final-calculator` with files like `advanced-calculator.c`, `Makefile`, `math-lib.c`, and `math-lib.h`.

7. **Successful Build:**
   - After resolving errors, a successful `bitbake final-calculator` execution is logged, indicating the issue was eventually fixed.

### Purpose:
This file serves as a step-by-step documentation of setting up and troubleshooting a Yocto build environment. It is particularly useful for debugging and understanding the workflow of adding layers and building Yocto recipes.
