### Task requirement
Create a new recipe that downloads source code from a given github repository. The goal is to understand the Yocto Project workflow around do_fetch() build task.

The file, `logger.txt`, is a detailed log of shell commands and their outputs. It appears to document the process of setting up a Yocto environment, creating a custom layer, and testing the `do_fetch` operation in BitBake. Here's a breakdown of its contents:

### Key Activities Documented:
1. **Installing Visual Studio Code**:
   - The user installs Visual Studio Code using the `snap install` command.
   - Command: `sudo snap install code --classic`.

2. **Creating a Custom Layer**:
   - The user creates a custom BitBake layer named `meta-do_fetch_example` via:
     ```bash
     bitbake-layers create-layer ../poky/meta-do_fetch_example
     ```
   - The log provides instructions to add the layer using `bitbake-layers add-layer`.

3. **Displaying Available Layers**:
   - The `bitbake-layers show-layers` command lists all active layers, including their priorities and paths. The new layer `meta-do_fetch_example` is added successfully.

4. **Running the `do_fetch` Command**:
   - The user runs the `do_fetch` task for a recipe named `example` using:
     ```bash
     bitbake -c do_fetch example
     ```
   - Logs show information about the build configuration, including Yocto environment variables, distribution version, and machine target.

5. **Inspecting the Downloads Directory**:
   - After running the `do_fetch` task, the user lists the contents of the `../sources/downloads/` directory. This directory contains various downloaded source files (.tar.gz, .tar.bz2, etc.) and their corresponding `.done` files, indicating successful downloads.

---

### Purpose:
The file serves as a step-by-step record of setting up and testing a Yocto custom layer (`meta-do_fetch_example`), with logs showing successful task execution. It also verifies that necessary source files are downloaded properly. This log can be used as a reference for replicating the setup or troubleshooting issues.
