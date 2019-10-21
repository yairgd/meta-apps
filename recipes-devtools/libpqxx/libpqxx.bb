DESCRIPTION = "C++ client API for PostgreSQL" 
SECTION = "examples" 
LICENSE = "CLOSED" 
#PR = "r0" 

DEPENDS = "postgresql"
SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=git;branch=6.4;"
SRCREV="d15839ee6a289b0c743f4417923f4bd19fd08a2c"

#SRCREV = "${AUTOREV}"

#SRC_URI[md5sum] = "68c0a133b30e39107a526580c4100a2b"
#SRC_URI[sha256sum] = "60aebd91b284f6eb304d49b1ff777f98c76ac79c34e8524b4caedb658da25236"






S = "${WORKDIR}/git"

inherit pkgconfig cmake

#do_install() {
#    install -d ${D}${bindir}
#    install -m 0755 cameracapture ${D}${bindir}
#}
