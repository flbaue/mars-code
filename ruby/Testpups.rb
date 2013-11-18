class Testpups

	def initialize hash
		@noise = hash[:noise]
	end

	def to_s
		"Dein " + Testpups.name + " macht " + @noise + "!"
	end
end

puts "Wie macht dein Testpups?"
noise = gets.chomp
foo = Testpups.new :noise => noise
puts foo


puts "Wie macht dein Testpups?"
foo = lambda {|n| "Igitt, Dein Pups macht " + n + "!"}
puts foo.call(gets.chomp)