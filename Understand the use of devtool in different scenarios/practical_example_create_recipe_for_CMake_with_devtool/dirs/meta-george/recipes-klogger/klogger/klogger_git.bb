# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://github.com/tianyuanhao/kernel-syslog.git;protocol=https;branch=main \
           file://0001-modified-the-Makefile.patch \
           file://0002-modified-Makefile.patch \
           file://0003-modified-Makefile.patch \
           "

# Modify these as desired
PV = "1.0"
SRCREV = "4c97833ad6ff0cd4ece49b30a17315192342847a"

S = "${WORKDIR}/git"

inherit module

EXTRA_OEMAKE:append:task-install = " -C ${STAGING_KERNEL_DIR} M=${S}"
# Kernel path in install makefile is hardcoded - you will need to patch the makefile. Note that the variable KERNEL_SRC will be passed in as the kernel source path.
