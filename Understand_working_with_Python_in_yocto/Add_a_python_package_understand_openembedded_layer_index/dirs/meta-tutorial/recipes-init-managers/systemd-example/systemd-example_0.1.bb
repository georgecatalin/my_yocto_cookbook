SUMMARY = "This is an example recipe for a systemd service"
DESCRIPTION = "This recipe demonstrates how to create a systemd service in Yocto."

LICENSE = "CLOSED"

inherit task-info-global


SRC_URI = "file://mysysd.service \
           file://mydaemon.sh "

S = "${WORKDIR}"

inherit systemd

RDEPENDS:${PN} = "bash"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "mysysd.service"

do_install() {
    echo "Installing systemd service and script"
    install -d ${D}${bindir}
    install -m 0644 ${S}/mydaemon.sh ${D}${bindir}

#  the .service file could go in either one of the following directories:
#    systemd_unitdir = /lib/systemd/
#    sysconfdir = /etc 

    install -d ${D}${sysconfdir}/systemd/system
    install -m 0644 ${S}/mysysd.service ${D}${sysconfdir}/systemd/system    
    
#    install -d ${D}/${systemd_unitdir}/system
#    install -m 0644 ${S}/sysd.service ${D}/${systemd_unitdir}/system
}   
