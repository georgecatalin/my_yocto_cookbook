# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

SRC_URI = "git://github.com/Munawar-git/factorial.git;protocol=https;branch=main"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "27134a05d6b5aa06a474bc0002f6541550ac51e0"

S = "${WORKDIR}/git"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

# add this to cope with the error of not sufficient rights to deploy -> mark deployment has to be done on the target,but not on this machine
# for this example, as I am building for qemu86-64 the file type of the binary will not be an issue , as destination is the same with the target, however set the CC and CFLAGS as per the destination 
# to cope with all situations including those when the target is different that the development machine
EXTRA_OEMAKE = "PREFIX=${D}${bindir} CC='${CC}' CFLAGS='${CFLAGS}'"


do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
        # add this to cope with the latter error of now existing directory, thus create it now
	install -d ${D}${bindir}
	oe_runmake install
}

