#bitbake -e <recipe-name> | grep ^WORKDIR=

SUMMARY = "curses-based interface to GDB"
DESCRIPTION = "cgdb is a lightweight curses (terminal-based) interface to the GNU Debugger (GDB)."
#HOMEPAGE = "http://cgdb.github.io/"
SECTION = "devel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

DEPENDS = "flex-native readline ncurses"

inherit autotools

SRC_URI = "git://github.com/cgdb/cgdb.git; \
	file://0001-remove-proc-self-status-is-available-for-checking-Tr.patch"
SRCREV="master"
#SRC_URI[md5sum] = "7bd38c79bf4d794d239928fef401fca3"
#SRC_URI[sha256sum] = "be203e29be295097439ab67efe3dc8261f742c55ff3647718d67d52891f4cf41"

CACHED_CONFIGUREVARS = "ac_cv_file__dev_ptmx=yes ac_cv_rl_version=6.2"
EXTRA_OECONF = "--with-readline=${STAGING_LIBDIR} \
    --with-ncurses=${STAGING_LIBDIR} "

RDEPENDS_${PN} = "gdb"

S = "${WORKDIR}/git"

# The autotools configuration I am basing this on seems to have a problem with a race condition when parallel make is enabled
PARALLEL_MAKE = ""



do_configure_prepend () {
	( cd ${S}; .  ./autogen.sh )
}

