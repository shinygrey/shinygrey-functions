module LambdaFunctions
	class Handler
		def self.process(event:,context:)
			{
				statusCode: 200,
				body: "{\"message\":\"Shiny Grey Serverless Ruby Lambda - Your function executed successfully!\"}"
			}
		end
	end
end
