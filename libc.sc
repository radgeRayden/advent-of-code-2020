vvv bind unistd
do
    let header =
        include "unistd.h"

    using header.extern
    using header.define
    using header.enum

    unlet header
    locals;

vvv bind string
do
    let header =
        include "string.h"

    using header.extern
    using header.define

    unlet header
    locals;

vvv bind stdlib
do
    let header =
        include "stdlib.h"

    using header.extern
    using header.define

    unlet header
    locals;

vvv bind stdio
do
    let header =
        include "stdio.h"

    using header.extern
    using header.define

    unlet header
    locals;

do
    let
        unistd
        string
        stdlib
        stdio
    locals;
