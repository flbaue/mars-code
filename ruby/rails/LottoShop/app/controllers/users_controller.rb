class UsersController < ApplicationController

	def index
		@users = User.all
	end
	
	def new
		
	end
	
	def create
		@user = User.new params
	end
end
