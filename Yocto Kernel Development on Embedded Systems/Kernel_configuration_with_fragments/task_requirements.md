# Objective
Demonstrate the workflow around configuring the Linux Kernel with Yocto Project using fragments.

## Notes
### Steps to follow 
* create .bbappend file
* modify Linux Kernel using the menuconfig Yocto utility
* save the modifications as .cfg (fragment)
* copy the fragment to the newly recipe created for the .bbappend
* cleansstate the prebuilt binaries associated with the Linux Kernel
* build the Linux Kernel with menuconfig again to prove the newly added settings are taken by default

### Important
The fragments driven method of updating the Linux Kernel has a higher priority opposite to the defconfig method for the same setting
