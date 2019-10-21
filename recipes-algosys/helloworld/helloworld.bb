#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
#-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed


DESCRIPTION = "Simple helloworld application"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"
#SRCREV = "${AUTOREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://helloworld.c;"
#SRC_URI = "git://git.multitech.net/helloworld-autotools.git;protocol=git"
#inherit autotools

S = "${WORKDIR}/"

do_compile() {
echo ${LDFLAGS}
	     ${CC} helloworld.c ${LDFLAGS} -o helloworld
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 helloworld ${D}${bindir}
}
