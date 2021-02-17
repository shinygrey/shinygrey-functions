const version = require('../package.json').version;
const stage = process.env.STAGE;
const timestamp = new Date();

function ifStringParse(item) {
	if(typeof item === 'string'){
		return JSON.parse(item);
	}else if(typeof item === 'object'){
		return item;
	}else{
		throw new Error('item was not string nor object');
	}
}

module.exports.handler = async event => {
	try{
		const eventChecked = ifStringParse(event);

		if(!('queryStringParameters' in eventChecked)){
			console.log('no querystringparams');
		}else if('code' in eventChecked.queryStringParameters) {
			console.log('code - ',eventChecked.queryStringParameters.code);
		}else{
			console.log('no code');
		}

		return {
			statusCode: 200,
			body: JSON.stringify({
				stage: stage,
				version: version,
				timestamp: timestamp.toLocaleString(),
				message: "Success!"
			})
		};
	}catch(e){
		console.error('error in igauth handler',e);
	}
	return {
		statusCode: 500,
		body: JSON.stringify({
			stage: stage,
			version: version,
			timestamp: timestamp.toLocaleString(),
			message: "Error!"
		})
	};
};
