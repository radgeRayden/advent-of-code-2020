let C = (import .libc)
using C.stdio
using import Map

let file = (fopen "input1.txt" "r")
assert (file != null)
fseek file 0 SEEK_END
let flen = (ftell file)
fseek file 0 SEEK_SET

local numbers : (Map i32 i32)
loop ()
    local line : (array i8 8)
    let ptr = (fgets &line (sizeof line) file)
    if (ptr == null)
        break;

    local number : i32
    assert ((sscanf &line "%d" &number) == 1)
    'set numbers number (number - 2020)

for k v in numbers
    try
        # if this key exists, then we found our complement
        'get numbers (abs v)
        print "part one:" (k * (abs v))
        break;
    else
        ;

label finish
    for a v in numbers
        for b v in numbers
            for c v in numbers
                if ((a + b + c) == 2020)
                    print "part two:" (a * b * c)
                    merge finish
