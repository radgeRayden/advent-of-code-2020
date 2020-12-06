local file = io.open("input6.txt")
local input = file:read("*a")
file:close()

local lpeg = require("lpeg")
local re = require("re")

local group_pattern  =
re.compile
[[
groups <- {|(group (%nl / ""))+|}
group <- {person+}
person <- [a-z]+ %nl
]]

local captures = re.match(input, group_pattern)

local count = 0
for k, v in ipairs(captures) do
  local chars = {}
  for c in v:gmatch("[a-z]") do
    chars[c] = c
  end
  for k, v in pairs(chars) do
    count = count + 1
  end
end
print ("anyone:", count)

local count = 0
for k, v in ipairs(captures) do
  local word_count = 0
  local chars = {}
  for word in v:gmatch("[a-z]+") do
    word_count = word_count + 1
    for c in word:gmatch("[a-z]") do
      chars[c] = chars[c] and (chars[c] + 1) or 1
    end
  end

  for k, v in pairs(chars) do
    if v == word_count then
      count = count + 1
    end
  end
end
print ("everyone:", count)
