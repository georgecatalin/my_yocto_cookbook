# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0ab4ff50a08ce4c8048a56510fc9b89c"

SRC_URI = "git://github.com/byuksel/Automake-Autoconf-Template-Project.git;protocol=https;branch=master"

# Modify these as desired
PV = "1.0.0+git${SRCPV}"
SRCREV = "c68ffd05045e31002e47b57897850329835e4b3e"

S = "${WORKDIR}/git"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

