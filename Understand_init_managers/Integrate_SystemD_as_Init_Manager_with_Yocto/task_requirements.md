# Objective
Create a 'core-image-full-cmdline' image for BeagleBone Black with Yocto that uses SystemD as the init manager, instead of SysVinit.

## Core advantages of SystemD as an Init Manager over Busybox Init and SysVinit
* allows starting of services in parallel
* allows setting service limits
* provides integrated logging
* allows service isolation

## Drawbacks of SystemD as an init manager
* it has a higher complexity than Busybox Init and SysVinit
* it has a bigger size than BusyBox init and SysVinit


### Note: What is an init manager in a Linux operating system?
The init manager is the first process that starts after rootfs is set, init manager has process id=1.
