# Step 1: Build the Angular app
FROM node:16 as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod

# Step 2: Serve the Angular app
FROM nginx:alpine
COPY --from=build /app/dist/front-app /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
