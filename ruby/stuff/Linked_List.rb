require './Linked_List_Element.rb'

class Linked_List
	include Enumerable

	def initialize
		@head = nil
		@tail = nil
	end

	def each
		elem = @head
		until elem.nil? do
			yield(elem)
			elem = elem.next
		end
	end

	def << value
		elem = Linked_List_Element.new ({ next: nil, back: @tail, value: value })
		@head = elem if @head.nil?
		@tail.next = elem unless @tail.nil?
		@tail = elem 
	end

	def to_s
		i = -1
		self.inject('') do |text, elem|
			i += 1
			text += "#{i}: #{elem} -> "
		end
	end

end