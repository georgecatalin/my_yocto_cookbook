SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created to show the functioning of do_patch() build operation"
LICENSE = "CLOSED"

SRC_URI = "file://advanced-calculator.c \
           file://math-lib.h \
           file://math-lib.c \
           file://Makefile \
"

S = "${WORKDIR}"

EXTRA_OEMAKE:append = " DESTDIR=${D} BINDIR=${bindir}"
EXTRA_OEMAKE:append = " TARGET=${PN}"

do_compile(){
   oe_runmake   
}

do_install(){
    oe_runmake install
}
