class Foo
	def bar x, y
		p x
		p y
	end
end


foo =  Foo.new
foo.bar :abc, xyz: { case_sensitive: "abc"}