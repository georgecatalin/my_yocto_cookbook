SUMMARY = "This is an example recipe to add a new user"
DESCRIPTION = "This recipe demonstrates how to add a new user to the system."
LICENSE = "CLOSED"

inherit useradd

# use this command to encrypt the password in command line : printf "%q" $(openssl passwd qwaszx) where "qwaszx" is the password you want to set.
# The output will be something like: $1$e3b0c44298fc....

PASSWD = "\$1\$aP3KGWdI\$E4xxS4KiqmJ89q/UiAWgB."

NEWUSER = "chucknorris"


USERADD_PACKAGES = "${PN}" 

USERADD_PARAM:${PN} += "-d /home/${NEWUSER} -p '${PASSWD}' ${NEWUSER}"

do_install() {
    # Create the home directory for the new user
    install -d ${D}/home/${NEWUSER}

}


FILES:${PN} += "/home/${NEWUSER}"
# This line ensures that the home directory is included in the package
# and will be created when the package is installed.