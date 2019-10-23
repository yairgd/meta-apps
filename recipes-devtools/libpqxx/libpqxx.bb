DESCRIPTION = "C++ client API for PostgreSQL" 
SECTION = "libpqxx" 
LICENSE = "CLOSED" 
#PR = "r0" 

DEPENDS = "postgresql "
SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=git;branch=6.4;"
SRCREV="d15839ee6a289b0c743f4417923f4bd19fd08a2c"

#SRCREV = "${AUTOREV}"

#SRC_URI[md5sum] = "68c0a133b30e39107a526580c4100a2b"
#SRC_URI[sha256sum] = "60aebd91b284f6eb304d49b1ff777f98c76ac79c34e8524b4caedb658da25236"


INSANE_SKIP_${PN}-dev="dev-elf   "
INSANE_SKIP_${PN} = "  "

#IMAGE_INSTALL_append=" ${PN} "



S = "${WORKDIR}/git"

inherit  cmake 
#pkgconfig
#PACKAGES = "${PN}"

INSANE_SKIP_${PN}-dev=" dev-elf packages-list dev-deps license-checksum file-rdeps dev-so host-user-contaminated staticdev installed-vs-shipped "
INSANE_SKIP_${PN} = "already-stripped  dev-deps  license-checksum file-rdeps  dev-so host-user-contaminated staticdev installed-vs-shipped  "



FILES_${PN} = "\
    ${bindir}/* \
    ${includedir}/* \
    ${sysconfdir} \
    ${libdir} \
    /usr/*\
    "
do_install_append() {
	mkdir -p ${D}/usr/lib
	touch ${D}/usr/lib/dummy
	cp ${WORKDIR}/build/src/libpqxx.so ${D}/usr/lib
#    install -d ${D}${bindir}
#    install -m 0755 cameracapture ${D}${bindir}
}
