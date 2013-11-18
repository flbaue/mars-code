#!/usr/bin/ruby

require 'sqlite3'

begin

	db = SQLite3::Database.new 'test.db'
	puts db.get_first_value 'SELECT SQLITE_VERSION()'

rescue SQLite3::Exception => e

	puts e

ensure

	db.close if db

end
