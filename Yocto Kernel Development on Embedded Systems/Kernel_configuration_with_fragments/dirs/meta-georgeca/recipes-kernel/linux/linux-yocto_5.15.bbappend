FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://gpio-sysfs.cfg"

# This file is used to configure the GPIO sysfs interface.
# It is included in the kernel build process to ensure that the sysfs
# interface is set up correctly for GPIO operations.        

# The file contains settings that define how GPIO pins are exported and managed
# through the sysfs interface. It may include configurations for pin numbering,
# default states, and other parameters necessary for GPIO operations.   