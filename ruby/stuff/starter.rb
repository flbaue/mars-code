$:.unshift(File.expand_path(File.dirname(__FILE__)))
#puts "$:"
#puts $:
#puts "$LOAD_PATH"
#puts $LOAD_PATH
require "Linked_List"


list = Linked_List.new

list << "one"
list << "two"
list << "three"

puts list