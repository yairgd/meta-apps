#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#
#-Wl,-O1 -Wl,--hash-style=gnu -Wl,--as-needed


DESCRIPTION = "installs FXCM  3'rd party libraries"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#SRCREV = "${AUTOREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://restbed.tar.gz \
"
PACKAGES = "${PN}-dbg ${PN} ${PN}-doc ${PN}-dev ${PN}-staticdev ${PN}-locale"




#SRC_URI = "git://git.multitech.net/helloworld-autotools.git;protocol=git"
#inherit autotools

S = "${WORKDIR}/"

#do_compile() {
#	echo ${LDFLAGS}
#	${CC} helloworld.c ${LDFLAGS} -o helloworld
#}


INSANE_SKIP_${PN}-dev=" dev-elf packages-list dev-deps license-checksum file-rdeps dev-so host-user-contaminated staticdev "
INSANE_SKIP_${PN} = "already-stripped  dev-deps  license-checksum file-rdeps  dev-so host-user-contaminated staticdev "



FILES_${PN} = "\
    ${bindir}/* \
    ${includedir}/* \
    ${sysconfdir} \
    ${libdir} \
    /usr/*\
    "




do_install() {
	mkdir  ${D}/usr/include/ -p
	mkdir  ${D}/usr/lib -p
	cp ${S}/lib/*     ${D}/usr/lib -arf
	cp ${S}/include/* ${D}/usr/include -arf

}

