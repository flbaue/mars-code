class Linked_List_Element

	attr_accessor :next, :back, :value

	def initialize hash
		@next = hash[:next]
		@back = hash[:back]
		@value = hash[:value]
	end

	def has_next
		!@next.nil?
	end

	def has_back
		!@back.nil?
	end

	def to_s
		@value
	end

end