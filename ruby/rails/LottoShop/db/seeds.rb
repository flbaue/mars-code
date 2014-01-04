# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

address = Address.create(street1: 'Hauptstraße 1', street2: '', city: 'Hamburg', postCode: '20095', country: 'Deutschland')
user = User.create(firstName: 'Johnny', lastName: 'Bravo', address: address)