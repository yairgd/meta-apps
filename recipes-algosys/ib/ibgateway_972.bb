#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
#-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed


DESCRIPTION = "Interactive Brokers (IB)  gateway installation"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRCREV = "${AUTOREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://ibgateway.tar.gz\
"

PACKAGES = "${PN}"



#SRC_URI = "git://git.multitech.net/helloworld-autotools.git;protocol=git"
#inherit autotools

S = "${WORKDIR}/"

#do_compile() {
#	echo ${LDFLAGS}
#	${CC} helloworld.c ${LDFLAGS} -o helloworld
#}


#INSANE_SKIP_${PN}-dev=" dev-elf packages-list dev-deps license-checksum file-rdeps dev-so host-user-contaminated "
#INSANE_SKIP_${PN} = "already-stripped  dev-deps  license-checksum file-rdeps  dev-so host-user-contaminated "



FILES_${PN} = "\
	/opt/IB/972/* \
        "




do_install() {
	mkdir ${D}/opt/IB/972 -p
	cp ${WORKDIR}/972/*  ${D}/opt/IB/972/ -rf

}

