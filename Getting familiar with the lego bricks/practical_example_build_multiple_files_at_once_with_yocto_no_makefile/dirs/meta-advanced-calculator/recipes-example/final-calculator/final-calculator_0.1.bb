SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created to show the functioning of do_patch() build operation"
LICENSE = "CLOSED"

SRC_URI = "file://advanced-calculator.c \
           file://math-lib.h \
           file://math-lib.c \
"

S = "${WORKDIR}"


do_compile(){
   ${CC}  ${CFLAGS} ${S}/math-lib.c -c -o math-lib.o
   ${CC}  ${CFLAGS} ${S}/advanced-calculator.c -c -o advanced-calculator.o
   ${CC}  ${CFLAGS} ${LDFLAGS}  ${S}/math-lib.o advanced-calculator.o -o final-calculator   
}

do_install(){
    install -d ${D}${bindir}
    install -m 755 final-calculator ${D}${bindir}
}
