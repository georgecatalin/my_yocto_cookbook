FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://gpio-sysfs.cfg"
SRC_URI += "file://dummy_driver.cfg"
SRC_URI += "file://0001-inserted-custom-char-driver-module.patch"
SRC_URI += "file://0001-new-commit.patch"
SRC_URI += "file://0001-supplementary-commit.patch"

   
