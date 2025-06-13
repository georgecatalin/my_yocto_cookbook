FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://0001-patch-example.patch"

do_configure:append(){
  echo '//this is a comment added via the .bbappend file' >> bbb-example.h
}
