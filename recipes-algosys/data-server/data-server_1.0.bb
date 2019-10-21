SUMMARY = "curses-based interface to GDB"
DESCRIPTION = "cgdb is a lightweight curses (terminal-based) interface to the GNU Debugger (GDB)."
HOMEPAGE = "http://cgdb.github.io/"
SECTION = "devel"
LICENSE = "Belkin-Lisence"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git//LICENSE;md5=a4de58bb0cfbf1057d8e0cb28cb34e16"
#BB_STRICT_CHECKSUM = "0"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS = " curl libwebsockets jsoncpp libpqxx libcap openssl    "
RDEPENDS_${PN}="data-server"

## IMAGE_INSTALL += "libunwind icu libcurl libssl10 curl"

inherit autotools
SRC_URI="git://git@github.com/yairgd/ecommerce.git;protocol=ssh"
SRCREV = "master"



S = "${WORKDIR}/git"

do_configure_prepend () {
	( cd ${S}/algotrade/algosys/; ./autogen.sh )
}

do_compile () {
	( cd ${S}//algotrade/algosys/build;make )
}


INSANE_SKIP_${PN}-dev=" dev-elf packages-list dev-deps license-checksum "
INSANE_SKIP_${PN} = "already-stripped  dev-deps  license-checksum "


FILES_${PN} = "\
    ${bindir}/* \
    ${sysconfdir} \
    ${libdir} \
    "
	
do_install() {
	mkdir ${D}/${bindir} -p
	mkdir ${D}/etc -p
	mkdir ${D}/${libdir} -p

	cp ${S}/algotrade/algosys/build/dataServer/dataServer         ${D}${bindir}
	cp ${S}/algotrade/algosys/build/StrategyRunner/strategyServer ${D}${bindir}
	cp ${S}/algotrade/etc/dataserver.conf 			      ${D}${sysconfdir}
	cp ${S}/algotrade/thirdParty/lib/libForexConnect.so	      ${D}${libdir}


}
