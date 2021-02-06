namespace AwsDotnetFsharp
open FSharp.Data
open Amazon.Lambda.APIGatewayEvents
open Amazon.Lambda.Core

[<assembly:LambdaSerializer(typeof<Amazon.Lambda.Serialization.SystemTextJson.DefaultLambdaJsonSerializer>)>]
do ()

module Handler =
    let hello(request:APIGatewayProxyRequest) =
        let method = request.HttpMethod
        APIGatewayProxyResponse(StatusCode = 200, Body = "{\"message\":{\"fsharp\":\"Shiny Grey Serverless! Your function executed successfully!\"}}")
