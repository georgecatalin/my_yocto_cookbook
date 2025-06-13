SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*                                             *");
    bb.plain("*  this is from .bbappend layer
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

do_configure:append(){
  echo 'printf("Added from the .bbappend recipe");' >> bbb-example.h
}
