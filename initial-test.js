import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 100,
    duration: '5m',
};

export default function () {
    const req = {
        referenceNo: "123"
    };

    const res = http.post('http://localhost:8080/PlaygroundController/customer-list', JSON.stringify(req), {
      headers: { 'Content-Type': 'application/json' }
    });

    check(res, {
        'status is 200': (r) => r.status === 200,
        'transaction time OK': (r) => r.timings.duration < 11000,
    });

    sleep(1); // 1 detik antara setiap request
}