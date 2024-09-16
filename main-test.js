import http from "k6/http";
import { check, sleep } from 'k6';

export const options = {
  vus: 5,
  duration: '6s',
};

export default function () {
  const res = http.get("http://localhost:8080/PlaygroundController/do-completeable-future");

  check(res, {
      'status is 200': (r) => r.status === 200,
      'transaction time OK': (r) => r.timings.duration < 3100,
  });

  sleep(1); // 1 detik antara setiap request
}