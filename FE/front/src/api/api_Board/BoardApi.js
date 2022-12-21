const URL = 'http://localhost:8080';

export function fetchPosts() {
  const response = fetch(`${URL}/posts`, {
    mode: 'cors',
    headers: {
      'Access-Control-Allow-Origin': '*',
    },
  })
    .then(response => response.json())
    .then(data => console.log(data));
  // .then(data => {
  //   return data.posts;
  // });
  return response;
}
