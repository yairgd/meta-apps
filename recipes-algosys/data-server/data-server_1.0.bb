SUMMARY = "curses-based interface to GDB"
DESCRIPTION = "cgdb is a lightweight curses (terminal-based) interface to the GNU Debugger (GDB)."
HOMEPAGE = "http://cgdb.github.io/"
SECTION = "devel"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


#BB_STRICT_CHECKSUM = "0"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS = " curl libwebsockets jsoncpp  libcap openssl  restbed libpqxx fxcm  "
RDEPENDS_${PN}="   libpqxx  fxcm "

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


}

# https://stackoverflow.com/questions/54660983/how-to-add-recipe-for-yocto-systemd-service
# Enable SUID bit for applications that need it
##pkg_postinst_${PN}-rltraceroute6 () {
##    chmod 4555 ${bindir}/rltraceroute6
##}
##pkg_postinst_${PN}-ndisc6 () {
##    chmod 4555 ${bindir}/ndisc6
##}
##pkg_postinst_${PN}-rdisc6 () {
##    chmod 4555 ${bindir}/rdisc6
##}
