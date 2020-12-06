let C = (import .libc)
using C.stdio
using import Map
using import Array

let file = (fopen "input1.txt" "r")
assert (file != null)
fseek file 0 SEEK_END
let flen = (ftell file)
fseek file 0 SEEK_SET

local numbers : (Map i32 i32)
local number-arr : (Array i32)
loop ()
    local line : (array i8 8)
    let ptr = (fgets &line (sizeof line) file)
    if (ptr == null)
        break;

    local number : i32
    assert ((sscanf &line "%d" &number) == 1)
    'set numbers number (number - 2020)
    'append number-arr number
    ;

for k v in numbers
    try
        # if this key exists, then we found our complement
        'get numbers (abs v)
        print "part one:" (k * (abs v))
        break;
    else
        ;

'sort number-arr
local iter = 0
label finish
    for a in number-arr
        for b in number-arr
            if ((a + b) < 2020)
                for c in number-arr
                    iter += 1
                    if ((a + b + c) == 2020)
                        print "part two:" (a * b * c)
                        merge finish
print iter

local iter = 0
label finish
    for a v in numbers
        for b v in numbers
            for c v in numbers
                iter += 1
                if ((a + b + c) == 2020)
                    print "part two:" (a * b * c)
                    merge finish
print iter
